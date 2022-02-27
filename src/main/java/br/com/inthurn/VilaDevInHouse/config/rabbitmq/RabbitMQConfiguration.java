//package br.com.inthurn.VilaDevInHouse.config.rabbitmq;
//
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConfiguration {
//
//    private String host;
//
//    private Integer port;
//
//    private String username;
//
//    private String password;
//
//    public RabbitMQConfiguration(@Value("${spring.rabbitmq.host:localhost}") String host, @Value("${spring.rabbitmq.port:5672}") Integer port, @Value("${spring.rabbitmq.username:guest}") String username, @Value("${spring.rabbitmq.password:guest}") String password) {
//        this.host = host;
//        this.port = port;
//        this.username = username;
//        this.password = password;
//    }
//
//    @Bean
//    public ConnectionFactory getConnectionFactory(){
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setHost(this.host);
//        connectionFactory.setPort(this.port);
//        connectionFactory.setUsername(this.username);
//        connectionFactory.setPassword(this.password);
//        connectionFactory.setConnectionCacheSize(10);
//        connectionFactory.setConnectionLimit(20);
//
//        return connectionFactory;
//    }
//
//}
