package Playground.Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SplitWiseAlgorithm {
	static class Person {
		String name;
		int money;

		@Override
		public String toString() {
			return "Person [name=" + name + ", money=" + money + "]";
		}

		public Person(String name, int money) {
			super();
			this.name = name;
			this.money = money;
		}

	}

	static class NetAmounts {
		ArrayList<Person> net = null;

		public NetAmounts(int friends) {
			super();
			this.net = new ArrayList<Person>();
		}

		public void transaction(String src, String dest, int amount) {
			int src_idx = find(src);
			int dest_idx = find(dest);

			if (src_idx != -1) {
				net.get(src_idx).money -= amount;
			} else {
				net.add(new Person(src, -amount));
			}

			if (dest_idx != -1) {
				net.get(dest_idx).money += amount;
			} else {
				net.add(new Person(dest, amount));
			}

		}

		public int find(String s) {
			for (int i = 0; i < net.size(); i++) {
				if (net.get(i).name == s) {
					return i;
				}
			}
			return -1;
		}

	}

	public static void solve(int friends, ArrayList<Person> net) {
		Comparator<Person> rule = (a, b) -> {
			return a.money - b.money;
		};

		ArrayList<Person> trascationList = new ArrayList<Person>();
		int totalTransaction = 0;
		for (Person x : net) {
			if (x.money > 0) {
				trascationList.add(x);
			} else if (x.money == 0) {

			} else {
				trascationList.add(x);
			}
		}
		Collections.sort(trascationList, rule);
		System.out.println(trascationList);
		while (trascationList.size() > 1) {

			Person debtor = trascationList.get(0);
			Person creditor = trascationList.get(trascationList.size() - 1);

			trascationList.remove(0);
			trascationList.get(trascationList.size() - 1);
			int settleAmt = Math.max(debtor.money, creditor.money);

			debtor.money += settleAmt;
			creditor.money -= settleAmt;
			System.out.println(debtor.name + " will pay  " + settleAmt + " to " + creditor.name);
			if (debtor.money != 0) {
				trascationList.add(debtor);
			}

			if (creditor.money != 0) {
				trascationList.add(creditor);
			}
			totalTransaction++;
			Collections.sort(trascationList, rule);
		}
		System.out.println(totalTransaction);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfTrasaction = 3;
		int friends = 3;

		NetAmounts netAmounts = new NetAmounts(friends);

		netAmounts.transaction("Ram", "sam", 100);
		netAmounts.transaction("sam", "jiten", 500);
		netAmounts.transaction("jiten", "Ram", 40);
		netAmounts.transaction("palak", "jiten", 140);

		solve(friends, netAmounts.net);

	}

}
