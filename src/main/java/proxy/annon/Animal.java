package proxy.annon;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Animal {
	
	public String value() default "Õ˙≤∆";
	
	public String Property() default "Œﬁ Ù–‘";
	
}
