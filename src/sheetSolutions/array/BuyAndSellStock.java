package sheetSolutions.array;

// @author tanishtha
// This program aims to find max profit while selling stocks
public class BuyAndSellStock {
    static int maxProfit1(int[] prices) {
        // brute force method o(n2)
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }

    static int maxProfit(int[] prices) {
        // we first find min in array and the max after that min value O(n);
        int minPrice = prices[0], maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(price - minPrice, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int ans = maxProfit(prices);
        int ans1 = maxProfit1(prices);
        System.out.println(ans);
        System.out.println(ans1);
    }
}
