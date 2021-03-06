package nintaco.api.local;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ApiMethod {
  int value() default 0;
  boolean autogenerated() default true;  
}
