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
      ave.M.a(Items.g, new oe());
      ave.M.a(Items.aP, new on());
      ave.M.a(Items.aD, new oo());
      ave.M.a(Items.bK, new op());
      ave.M.a(Items.bz, new oq());
      ave.M.a(Items.bJ, new os());
      ave.M.a(Items.cb, new ot());
      ave.M.a(Items.bL, new ou());
      ave.M.a(Items.aE, new ov());
      of var0 = new of();
      ave.M.a(Items.ay, var0);
      ave.M.a(Items.ax, var0);
      ave.M.a(Items.aw, new og());
      ave.M.a(Items.d, new oh());
      ave.M.a(Items.aW, new oi());
      ave.M.a(alq.a(aty.W), new oj());
      ave.M.a(Items.bX, new ok());
      ave.M.a(alq.a(aty.aU), new ol());
      ave.M.a(alq.a(aty.bX), new om());
   }

   public static void c() {
      if(!b) {
         b = true;
         if(c.isDebugEnabled()) {
            d();
         }

         Block.R();
         avx.j();
         alq.t();
         ty.a();
         b();
      }
   }

   private static void d() {
      System.setErr(new pc("STDERR", System.err));
      System.setOut(new pc("STDOUT", a));
   }

}
