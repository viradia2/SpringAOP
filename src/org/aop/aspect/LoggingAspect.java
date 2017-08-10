package org.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//Convert Normal Class into Aspect By writing Annotation @Aspect

@Aspect
public class LoggingAspect {
	
	/******************************************************************
	 * SINGLE ADVICE - MULTIPLE POINTS
	 * 
	 * Before Annotation to advice application that run this method before
	 * calling particular Methods.
	
	 * 
	 * To Specify the class name we can write 
	 * org.aop.model.Circle.getName()
	 * |-------------------||--------|
	 *          |                |
	 *          |                |
	 *     Class Name       Method Of Class
	 *     
	 * Otherwise for General (i.e. we want to advice on method name only
	 * no matter which class has the method)
	 * 
	 * We can use wild cards * for all the getters (public * get*())
	 * which means that all the getters and whatever their return type will
	 * they should run the advice.
	 * 
	 * For arguments we can use .. which means no arguments or any number of arguments
	 * 
	 * POINTCUT- used for single Point multiple advice
	 * 
	 * @Pointcut("execution(method name with wild card)")
	 * execution, within(For declaring class name)
	 * args(for arguments)
	 * 
	 * @After AOP Advice
	 * It will run advice after particular method execution, It will run in any case 
	 * i.e compile error , Runtime error.
	 * 
	 * @AfterReturning AOP Advice
	 * It will run only if methods return successfully without any error.
	 * 
	 * @AfterThrowing AOP Advice
	 * It will execute after throwing an exception from a target method
	 *******************************************************************/
	
	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint){
	}
	
	@Before("args(name)")
	public void StringArgumentMethod(String name){
		System.out.println("A method which take arguments as a String, Value: " + name);
	}
	
	/************************************************************************
	 * CATCHING A RETURN OBJECT
	 * 
	 * @Before(pointcut="args(name)", returning="returnString") 
	 *	public void StringArgumentMethod(String name, String returnString){
	 *	System.out.println("A method which take arguments as a String, Value: 
	 *		 " + name + "Return Value: "+ returnString);
	 *	}
	 *	
	 *	returning value should be an argument of an advice. We can declare that
	 *	arg as Object so it can return any type of object.
	 *
	 *
	 *	CATHING AN EXCEPTION
	 *
	 *	@Before(pointcut="args(name)", throwing="ex")
	 *	public void StringArgumentMethod(String name, Exception ex){
	 *		System.out.println("An Exception has been thrown: " + ex);
	 *  }
	 *
	 *************************************************************************/
	
	@Pointcut("within(org.aop.model.Circle)")
	public void allCircleMethods(){
		
	}
}
