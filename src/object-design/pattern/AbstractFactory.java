import java.io.*;


// Bank class
public interface Bank {

}

class HSBC implements Bank {

}

// Loan class
public abstract class Loan {

}

class HomeLoan extends Loan {

}

// Factory class
abstract class AbstractFactory {
    public abstract Bank getBank();
    public abstract Loan getLoan();
}

class BankFactory extends AbstractFactory {

}

class LoanFactory extends AbstractFactory {

}

// Create factory instance
class FactoryCreator {
    public AbstractFactory getFactory() {
        return null;
    }
}
