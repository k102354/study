package soo.jun.kim.study;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;


public class ProxyTest2 {

    // 프록시를 적용할 구현체
    class TargetImpl {

        public void print() {
            System.out.println("Hello!");
        }
    }

    // Proxy 생성 및 호출 test
    @Test
    void test() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetImpl.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            System.out.println("[start] - method");
            Object result = proxy.invoke(obj, args);
            System.out.println("[end] - method");
            return result;
        });
        TargetImpl proxy = (TargetImpl) enhancer.create();
        proxy.print();
    }
}
