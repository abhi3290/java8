package com.abhi.blog.synchronization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Abhishek on 2/21/2017.
 */
public class MultiThreadedApp {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		List<Future<Boolean>> results = new ArrayList<>();

		int threads = 3;
		ExecutorService threadPool = Executors.newFixedThreadPool(threads);

		AccountController accountController1 = new AccountController();
		AccountController accountController2 = new AccountController();

		Future<Boolean> result1 = threadPool.submit(new Callable<Boolean>() {
			@Override
			public Boolean call() throws InterruptedException {
				return accountController1.debitFromAccount("11111", 50.0);
			}
		});

		results.add(result1);

		Future<Boolean> result2 = threadPool.submit(new Callable<Boolean>() {
			@Override
			public Boolean call() throws InterruptedException {
				return accountController2.debitFromAccount("11111", 50.0);
			}
		});

		results.add(result2);

		threadPool.shutdown();
		while (!threadPool.isTerminated()) {
		}

		for (Future<Boolean> future : results) {
			Boolean debitStatus = future.get();
			System.out.println("Result Status :"+ debitStatus);

		}


	}
}


class AccountId {
	private String accountNumber;

	public AccountId(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}


}

class AccountController {
	private AccountService accountService;

	public AccountController() {
		accountService = new AccountService();
	}
	public boolean debitFromAccount(final String accountNumber, Double amount) throws InterruptedException {
		if(!accountService.getAccountIdMap().containsKey(accountNumber)) {
			accountService.getAccountIdMap().put(accountNumber, new AccountId(accountNumber));
		}

		AccountId accountId = accountService.getAccountIdMap().get(accountNumber);
		return accountService.debitFromAccount(accountId, 50.0);

	}

}

class AccountService {
	public static Map<String, AccountId> accountIdMap = new HashMap<>();

	public boolean debitFromAccount(final AccountId accountId, Double amount) throws InterruptedException {
		boolean status = false;
		System.out.println("Before entering critical code");

		synchronized (accountId) {
			System.out.println("Inside critical code");
			System.out.println("Debating from account");
			Thread.sleep(2000);
			System.out.println("Existing critical code");
		}

		return status;
	}

	public Map<String, AccountId> getAccountIdMap() {
		return accountIdMap;
	}
}