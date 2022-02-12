package java8;

@FunctionalInterface
public interface MyInterfaceWithGenerics<T, U, R> {

	R logtoConsole(T t, U u);

}
