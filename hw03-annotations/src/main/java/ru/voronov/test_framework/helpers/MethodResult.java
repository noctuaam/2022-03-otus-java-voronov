package ru.voronov.test_framework.helpers;

/**
 * @author Aleksandr Voronov
 */
public class MethodResult {

    private final State state;
    private final String methodName;
    private String message;

    public MethodResult(State state, String methodName) {
        this.state = state;
        this.methodName = methodName;
    }

    public enum State {

        SUCCESS("пройдено"),
        ERROR("ошибка");

        private final String state;

        State(String state) {
            this.state = state;
        }

        @Override
        public String toString() {
            return String.format("[ %s ]", state.toUpperCase());
        }
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
            resultString.append(this.methodName)
                    .append(": Статус = ")
                    .append(this.state)
                    .append(this.message != null ? " Сообщение: " : "")
                    .append(this.message != null ? this.message : "")
                    .append("\n");
        return resultString.toString();
    }

    public boolean errorState(){
        return this.state == State.ERROR;
    }

    public boolean successState(){
        return this.state == State.SUCCESS;
    }

    public MethodResult setMessage(String message) {
        this.message = message;
        return this;
    }
}
