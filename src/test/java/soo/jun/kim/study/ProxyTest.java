package soo.jun.kim.study;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    // 인터페이스
    interface Target {
        void print();
    }

    // 프록시를 적용할 구현체
    class TargetImpl implements Target {
        @Override
        public void print() {
            System.out.println("Hello!");
        }
    }

    // InvocationHandler 구현체
    class TestHandler implements InvocationHandler {

        private Object target;

        public TestHandler(final Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
            System.out.println("[start] - method");
            Object result = method.invoke(target, args);
            System.out.println("[end] - method");
            return result;
        }
    }

    // Proxy 생성 및 호출 test
    @Test
    void test() {
        Target proxy = (Target) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class[]{Target.class},
                new TestHandler(new TargetImpl())
        );
        proxy.print();
    }
}