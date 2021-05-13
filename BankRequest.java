package challenges.codefights;

import challenges.AbstractCustomTestRunner;

/*
@author Kishan-Gupta
*/
public class BankRequests extends AbstractCustomTestRunner {

    int[] bankRequests(int[] balances, String[] requests) {
        for (int idx = 0; idx < requests.length; idx ++) {
            String[] r = requests [idx].split(" ");
            if (r [0].equalsIgnoreCase("deposit")) {
                int aIdx = Integer.valueOf(r [1]) - 1,
                        sum = Integer.valueOf(r [2]);

                if (aIdx >= balances.length) return new int [] { - (idx + 1) };
                balances [aIdx] += sum;
            }
            else if (r [0].equalsIgnoreCase("withdraw")) {
                int aIdx = Integer.valueOf(r [1]) - 1,
                        sum = Integer.valueOf(r [2]);

                if (aIdx >= balances.length || balances [aIdx] < sum) return new int [] { - (idx + 1) };
                balances [aIdx] -= sum;
            }
            else if (r [0].equalsIgnoreCase("transfer")) {
                int aIdx = Integer.valueOf(r [1]) - 1,
                        bIdx = Integer.valueOf(r [2]) - 1,
                        sum = Integer.valueOf(r [3]);

                if (aIdx >= balances.length ||  bIdx >= balances.length || balances [aIdx] < sum) return new int [] { - (idx + 1) };
                balances [aIdx] -= sum;
                balances [bIdx] += sum;
            }

            else return new int [] { - (idx + 1) };
        }
        return balances;
    }

}
