/* Program:  DynamicChangeMaker

*/
import java.util.Arrays;


public class DynamicChangeMaker {

  
    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.\n");
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.\n");
                        printUsage();
                        return;
                    }
                }
            }

            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.\n");
                printUsage();
                return;
            }



            Tuple change = makeChangeWithDynamicProgramming(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }

        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.\n");
            printUsage();
        }
    }

 
    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {


      for (int d = 0; d < denominations.length; d++) {

          if (denominations[d] <= 0) {
              throw new  IllegalArgumentException("Denominations must all be greater than zero...");
          }

          for (int e = 0; e < d; e++) {
              if (denominations[e] == denominations[d]) {
                  throw new IllegalArgumentException("Duplicate denominations are not allowed.");
              }
          }
      }

      if (amount < 0) {
          throw new IllegalArgumentException("Change cannot be made for negative amounts.");
      }

        int total_row = denominations.length;
        int total_column = amount + 1;
        Tuple[][] table = new Tuple[total_row][total_column];
        Arrays.sort(denominations);

        for (int i = 0; i < total_row; i++) {
          for (int j = 0; j <= amount; j++) {
            if (j == 0) {
              table[i][0] = new Tuple(total_row);
            }

            else if ((denominations[i] <=j) && (j % denominations[i] == 0)) {         
                  table[i][j] = new Tuple(total_row);
                  if (j - denominations[i] == 0) {
                    table[i][j].setElement(i, 1);
                  } else if (j - denominations[i] > 0) {
                    table[i][j].setElement(i, 1);
                    table[i][j] = table[i][j].add(table[i][j - denominations[i]]);
                  }
            } else if  ((denominations[i] < j) && (j % denominations[i] != 0)) { 
                  if (i - 1 < 0) {
                    table[i][j] = Tuple.IMPOSSIBLE;
                  } else if (i - 1 >= 0) {
                      table[i][j] = new Tuple(total_row);

                      table[i][j].setElement(i, 1);
                        if (table[i][j - denominations[i]].equals(Tuple.IMPOSSIBLE)) {
                          table[i][j] = Tuple.IMPOSSIBLE;
                          if (!(table[i-1][j].equals(Tuple.IMPOSSIBLE))) {
                            table[i][j] = table[i-1][j];
                          }
                        } else {
                          table[i][j] = table[i][j - denominations[i]].add(table[i][j]);
                          if (!(table[i-1][j].equals(Tuple.IMPOSSIBLE))) {
                            int sum_above = table[i - 1][j].total();
                            int sum_curr = table[i][j].total();
                            if (sum_above < sum_curr) {
                              table[i][j] = table[i-1][j];
                            }

                          }
                        }

                    }

              } else if (denominations[i] > j) {
                if (i - 1 < 0) {
                  table[i][j] = Tuple.IMPOSSIBLE;
                } else if (i - 1 >= 0) {
                    table[i][j] = Tuple.IMPOSSIBLE;
                    if (!(table[i-1][j].equals(Tuple.IMPOSSIBLE))) {
                      table[i][j] = table[i-1][j];
                    }

              }
            }

                if ((j == amount) && ((i - 1 >= 0) && (!(table[i -1][j].equals(Tuple.IMPOSSIBLE))) )) {
                    int sum1 = table[i][j].total();
                    int sum2 = table[i - 1][j].total();
                    if (sum2 < sum1) {
                      table[i][j] = table[i - 1][j];
                    }
                }
              }
            }



          if (!(table[total_row - 1][total_column - 1].equals(Tuple.IMPOSSIBLE))) {
            return table[total_row - 1][total_column - 1];
          } else {
              return Tuple.IMPOSSIBLE;
          }
    }

  
    private static void printUsage() {
        System.out.println("Usage: java DynamicChangeMaker <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

  
    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }
  }
