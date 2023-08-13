package SD;
//Builder pattern
public class URL {
    private String protocol;
    private String hostName;
    private String port;
    private String pathParam;
    private String queryParam;

    public URL() {
    }

    public URL(Builder builder) {
        this.protocol = builder.protocol;
        this.hostName = builder.hostName;
        this.port = builder.port;
        this.pathParam = builder.pathParam;
        this.queryParam = builder.queryParam;
    }

    public static class Builder {
        private String protocol;
        private String hostName;
        private String port;
        private String pathParam;
        private String queryParam;

        public Builder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder hostName(String hostName) {
            this.hostName = hostName;
            return this;
        }

        public Builder port(String port) {
            this.port = port;
            return this;
        }

        public Builder pathParam(String pathParam) {
            this.pathParam = pathParam;
            return this;
        }

        public Builder queryParam(String queryParam) {
            this.queryParam = queryParam;
            return this;
        }

        public URL build() {
            return new URL(this);
        }
    }

    public static void main(String[] args) {
        URL.Builder builderOne = new URL.Builder();
        URL url = builderOne.protocol("https://").hostName("localhost:").port("8080").build();
        System.out.print(url.protocol);
        System.out.print(url.hostName);
        System.out.print(url.port);

    }
}
