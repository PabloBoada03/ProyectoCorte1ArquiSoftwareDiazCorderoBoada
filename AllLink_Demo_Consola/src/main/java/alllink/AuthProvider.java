package alllink;

public class AuthProvider {
    private LoginStrategy strategy;

    public void setStrategy(LoginStrategy strategy) {
        this.strategy = strategy;
    }

    public void login() {
        if (strategy != null) strategy.login();
    }
}
