package io.company.library.utilities;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //we create routes to define operations and functions
    //we do that with MessageBrokerRegistry object
    @Override
    public void configureMessageBroker(MessageBrokerRegistry configuration) {

        configuration.enableSimpleBroker("/message");
        configuration.setApplicationDestinationPrefixes("/app");

    }

    //we assign an endpoint to the stompclient, that is, to make a real connection
    //connection between client-server, client-js and server-java
    //how? with StompEndpointRegistry object
    @Override
    public void registerStompEndpoints (StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();

    }

}