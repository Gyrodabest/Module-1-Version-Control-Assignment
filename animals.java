
public class animals {

	Animal2.java

	import java.util.concurrent.ThreadLocalRandom;

	public class Animal2 implements Runnable {

	   private Food food;
	   private String name;
	   private int position;
	   private int speed;
	   private int restMax;
	   private static boolean winner = false;

	   public Animal2(Food food) {
	       this.food = food;
	   }

	   public String getName() {
	       return name;
	   }

	   public void setName(String name) {
	       this.name = name;
	   }

	   public int getPosition() {
	       return position;
	   }

	   public void setPosition(int position) {
	       this.position = position;
	   }

	   public int getSpeed() {
	       return speed;
	   }

	   public void setSpeed(int speed) {
	       this.speed = speed;
	   }

	   public int getRestMax() {
	       return restMax;
	   }

	   public void setRestMax(int restMax) {
	       this.restMax = restMax;
	   }

	   public static void main(String[] args) {

	       Food food = new Food();
	       Animal2 rabbit = new Animal2(food);
	       rabbit.setName("Rabbit");
	       rabbit.setPosition(0);
	       rabbit.setRestMax(150);
	       rabbit.setSpeed(5);
	       Animal2 turtle = new Animal2(food);
	       turtle.setName("Turtle");
	       turtle.setPosition(0);
	       turtle.setRestMax(100);
	       turtle.setSpeed(3);
	       Thread rabbitThread = new Thread(rabbit);
	       Thread turtleThread = new Thread(turtle);

	       rabbitThread.start();
	       turtleThread.start();
	   }

	   @Override
	   public void run() {

	       while (position <= 100 && !winner) {
	           position += speed;
	           System.out.println(getName()+" started eating.");
	           food.eat(getRestMax());
	           System.out.println(getName()+" stopped eating.");
	           if (position >= 100) {
	               winner = true;
	              
	           }

	       }

	   }

	}

	Food.java


	public class Food {

	   synchronized void eat(long sleep) {
	       try {
	           Thread.sleep(sleep);
	       } catch (InterruptedException e) {

	           e.printStackTrace();
	       }
	   }

	}
}
