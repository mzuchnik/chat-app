package pl.mzuchnik.communicatorserver.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mzuchnik.communicatorserver.service.UserMessageUpdater;

@Aspect
@Component
public class UserUpdaterAdvice {

    private UserMessageUpdater userMessageUpdater;

    @Autowired
    public UserUpdaterAdvice(UserMessageUpdater userMessageUpdater) {
        this.userMessageUpdater = userMessageUpdater;
    }

    @Pointcut("execution(* pl.mzuchnik.communicatorserver.service.WebSocketEventListener.handleWebSocketDisconnectListener(..))")
    public void userDisconnected(){}

    @Pointcut("execution(* pl.mzuchnik.communicatorserver.controller.ChatController.addUser(..))")
    public void userAdded(){}

    @After("userAdded() || userDisconnected()")
    public void updateUsers(){
        userMessageUpdater.update();
    }
}
