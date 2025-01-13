package ModelHotelu;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class CustomExceptionHandler implements TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        System.out.println("Wystąpił wyjątek podczas wykonywania testu: " + context.getDisplayName());
        System.out.println("Treść wyjątku: " + throwable.getMessage());
        // Rzuć wyjątek ponownie, aby test mógł zakończyć się niepowodzeniem
        throw throwable;
    }
}
