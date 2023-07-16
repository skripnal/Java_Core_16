package task;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		Class inst =  Person.class;
		
		System.out.println("Ім'я класу з пакетом: " + inst.getName());
		System.out.println("Ім'я класу: " + inst.getSimpleName());
		System.out.println("Клас: " + inst.getClass());
		System.out.println("Модифікатор класу: " + Modifier.toString(inst.getModifiers()));
		System.out.println("Чи є клас статичним: " + Modifier.isStatic(inst.getModifiers()));
		System.out.println("Чи є клас публічним: " + Modifier.isPublic(inst.getModifiers()));
		System.out.println("Чи є клас абстрактним: " + Modifier.isAbstract(inst.getModifiers()));
		
		Package classPackage = inst.getPackage();
		System.out.println("Папка де знаходиться клас: " + classPackage);
		
		Class superClass = inst.getSuperclass();
		System.out.println("Супер клас: " + superClass);
		
		Class[] interfaces = inst.getInterfaces();
		System.out.println("Інтерфейси: " + Arrays.toString(interfaces));
		
		System.out.println();
		
		Constructor<Person>[] constructors = inst.getConstructors();
		for (Constructor<Person> constructor : constructors) {
			System.out.println("Конструктор: " + constructor);
		}
		System.out.println("Кількість конструкторів: " + constructors.length);
		
		System.out.println();
		
		Method[] methods = inst.getMethods();
		for (Method method : methods) {
			System.out.println("Метод: " + method);
		}
		System.out.println("Кількість методів: " + methods.length);
		
		System.out.println();
		
		Constructor<Person> constructor = inst.getConstructor(int.class, String.class);
		System.out.println("Конструктор за параметрами int, String: " + constructor);
		
		System.out.println();
		
		Field[] fields = inst.getDeclaredFields();
		for (Field field : fields) {
			System.out.println("Поле: " + field);
		}
		
		System.out.println();
		
		Person newInstance = constructor.newInstance(1, "Олександр");
		System.out.println("Створений об'єкт за допомогоюю рефлексії: " + newInstance);
		Field firstNameField = inst.getDeclaredField("firstName");
		firstNameField.setAccessible(true);
		firstNameField.set(newInstance, "Змінене ім'я");
		System.out.println("Поле firstName було переприсвоєне за допомогою рефлексії: " + newInstance);
		String[] argsString = {""};
		int[] argsInt = {};
		inst.getMethod("myMethod", String[].class).invoke(newInstance, (Object)argsString);
		inst.getMethod("myMethod", String.class, int[].class).invoke(newInstance, "", argsInt);
	}

}
