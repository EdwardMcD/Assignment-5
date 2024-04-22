# Assignment-5
Assignment – 5 [ 100 Points ] CSC-413-02 Spring 2024 San Francisco State University Computer Science Department

I built these files out within my Assignment 3. However, due to the submission guildelines, these files are out of their directory heirarchy. For refrence, here is their heirarchy outside of this submission:

│   .DS_Store
│   bankdb.db
│   pom.xml
│   README.md
│
├───.idea
│       .gitignore
│       Assignment-2-Business-and-Access-Objects.iml
│       compiler.xml
│       encodings.xml
│       jarRepositories.xml
│       misc.xml
│       uiDesigner.xml
│       vcs.xml
│       workspace.xml
│
├───src
│   │   .DS_Store
│   │
│   ├───main
│   │   │   .DS_Store
│   │   │
│   │   └───java
│   │       │   .DS_Store
│   │       │
│   │       └───A2_BaAO
│   │           │   .DS_Store
│   │           │   Account.java
│   │           │   Customer.java
│   │           │   DatabaseInitializer.java
│   │           │   Main.java
│   │           │   PriorityQueue.java
│   │           │   Transaction.java
│   │           │
│   │           ├───Assign5
│   │           │       BankAccountTransaction.java
│   │           │       DepositTransaction.java
│   │           │       Driver.java
│   │           │       TransactionInterface.java
│   │           │       WithdrawTransaction.java
│   │           │
│   │           ├───dao
│   │           │       .DS_Store
│   │           │       AccountDAO.java
│   │           │       AccountDAOImpl.java
│   │           │       CustomerDAO.java
│   │           │       CustomerDAOImpl.java
│   │           │       TransactionDAO.java
│   │           │       TransactionDAOImpl.java
│   │           │
│   │           ├───dto
│   │           │       .DS_Store
│   │           │       AccountDTO.java
│   │           │       CustomerDTO.java
│   │           │       TransactionDTO.java
│   │           │
│   │           └───gui
│   │               │   AccountCreationScreen.java
│   │               │   AccountViewScreen.java
│   │               │   BankAccountCreationScreen.java
│   │               │   LoginScreen.java
│   │               │   TransferMoneyScreen.java
│   │               │
│   │               └───controller
│   │                       AccountCreationController.java
│   │                       AccountViewController.java
│   │                       LoginController.java
│   │                       TransferMoneyController.java
│   │
│   └───test
│       │   .DS_Store
│       │
│       └───java
│               .DS_Store
│               Assignment5JUnitTestCases.java
│               JUnitTestCases.java
│
└───target
    ├───classes
    │   └─── [CLASSES]
    │
    ├───generated-sources
    │   └───annotations
    ├───generated-test-sources
    │   └───test-annotations
    └───test-classes

As you can see, the created files were stored in an Assign5\ directory for organization reasons. Additionally, I decided to use JUnit test cases for my Driver (test), which can be found in ...\src\test\java\

Now for this zipped submission:

    Account.java
    Assignment5JUnitTestCases.java
    BankAccountTransaction.java
    Customer.java
    DepositTransaction.java
    Driver.java
    README.md
    TransactionInterface.java
    WithdrawTransaction.java

OBJECTIVE 1:

1. The assignment outline refers to this class as BankCustomer, however I have been referring to it as simple "Customer." Therefore, for ease of access, I have continued with this naming convention. The builder class and its specifications can be found in the updated Customer.java. For the sake of this assignment, please regard Customer.java as BankCustomer.

2. I began creating a test driver named Driver.java. I included it to "show my work" in a sense, however I transitioned to using JUnit tests (these can be seen in Assignment5JUnitTestCases.java). These proved to be much easier for me to work with. Please use this instead of Driver.java.


OBJECTIVE 2:

1. As with BankCustomer, this assignment refers to a class named BankAccount. I have been referring to this as Account, and I will continue to do so for ease of access. I have included my Account.java in this submission. Please regard Account.java as BankAccount.

2. I have included TransactionInterface.java, an interface with a method execute().

3. DepositTransaction.java and WithdrawTransaction.java have been included with this submission. They are also tested in Assignment5JUnitTestCases.java.

4. BankAccountTransaction.java has been included with this submission to the specifications of the assignment.

5. This is tested within the JUnit tests, which have been included with the submission.