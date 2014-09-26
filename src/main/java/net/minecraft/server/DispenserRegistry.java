package net.minecraft.server;
import java.io.PrintStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DispenserRegistry {

   private static final PrintStream a = System.out;
   private static boolean b = false;
   private static final Logger c = LogManager.getLogger();


   public static boolean a() {
      return b;
   }

   static void b() {
      BlockDispenser.M.a(Items.ARROW, new DispenserBehaviorArrow());
      BlockDispenser.M.a(Items.aP, new DispenserBehaviorEgg());
      BlockDispenser.M.a(Items.aD, new DispenserBehaviorSnowBall());
      BlockDispenser.M.a(Items.bK, new DispenserBehaviorExpBottle());
      BlockDispenser.M.a(Items.POTION, new DispenserBehaviorPotion());
      BlockDispenser.M.a(Items.bJ, new DispenserBehaviorMonsterEgg());
      BlockDispenser.M.a(Items.cb, new DispenserBehaviorFireworks());
      BlockDispenser.M.a(Items.bL, new DispenserBehaviorFireball());
      BlockDispenser.M.a(Items.aE, new DispenserBehaviorBoat());
      DispenserBehaviorFilledBucket var0 = new DispenserBehaviorFilledBucket();
      BlockDispenser.M.a(Items.ay, var0);
      BlockDispenser.M.a(Items.ax, var0);
      BlockDispenser.M.a(Items.BUCKET, new DispenserBehaviorEmptyBucket());
      BlockDispenser.M.a(Items.FLINT_AND_STEEL, new DispenserBehaviorFlintAndSteel());
      BlockDispenser.M.a(Items.aW, new DispenserBehaviorBonemeal());
      BlockDispenser.M.a(Item.getItemOf(Blocks.TNT), new DispenserBehaviorTNT());
      BlockDispenser.M.a(Items.bX, new DispenserBehaviorSkull());
      BlockDispenser.M.a(Item.getItemOf(Blocks.PUMPKIN), new DispenserBehaviorPumpkin());
      BlockDispenser.M.a(Item.getItemOf(Blocks.COMMAND), new DispenserBehaviorCommand());
   }

   public static void c() {
      if(!b) {
         b = true;
         if(c.isDebugEnabled()) {
            d();
         }

         Block.R();
         BlockFire.j();
         Item.t();
         StatisticList.a();
         b();
      }
   }

   private static void d() {
      System.setErr(new pc("STDERR", System.err));
      System.setOut(new pc("STDOUT", a));
   }

}
