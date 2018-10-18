package com.zingoworks.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    private Account account;
    /*
        Test the program before you write it.
        Clean code that works.


        name : blabla
        argument : int a
        return : int a
        action : 10+15 = 25, return 25

        Account Class 테스트
        1. 잔고조회
        2. 입금/출금
        3. 예상복리이자(추가예정)
    */

    @Test
    public void testAccount() throws Exception {
    }

    private void setup() {
        account = new Account(10000);
    }

    @Test
    public void testGetBalance() {
        assertEquals("10000원으로 계좌 생성 후 잔고조회", 10000, account.getBalance());

        account = new Account(0);
        assertEquals("0원으로 계좌 생성 후 잔고조회", 0, account.getBalance());

    }

    @Test
    public void testDeposit() throws Exception {
        account.deposit(10000);
        assertEquals(20000, account.getBalance());
    }

    @Test
    public void testWithdraw() throws Exception {
        account.withdraw(10000);
        assertEquals(0, account.getBalance());
    }

    public static void main(String[] args) {
        AccountTest test = new AccountTest();
        try {
            test.testAccount();
        } catch (Exception e) {
            System.out.println("실패");
            return;
        }
        System.out.println("성공");
    }




}