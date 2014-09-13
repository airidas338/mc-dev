package net.minecraft.server;
import java.util.List;

public class bci extends bcm {

   private int a;
   private fv f;
   private boolean g;
   private List h;
   private List i;
   private String j;


   public void a(amj var1) {
      this.f = null;
      if(var1.n() && var1.o().b("BlockEntityTag", 10)) {
         fn var2 = var1.o().m("BlockEntityTag");
         if(var2.c("Patterns")) {
            this.f = (fv)var2.c("Patterns", 10).b();
         }

         if(var2.b("Base", 99)) {
            this.a = var2.f("Base");
         } else {
            this.a = var1.i() & 15;
         }
      } else {
         this.a = var1.i() & 15;
      }

      this.h = null;
      this.i = null;
      this.j = "";
      this.g = true;
   }

   public void b(fn var1) {
      super.b(var1);
      var1.a("Base", this.a);
      if(this.f != null) {
         var1.a("Patterns", (gd)this.f);
      }

   }

   public void a(fn var1) {
      super.a(var1);
      this.a = var1.f("Base");
      this.f = var1.c("Patterns", 10);
      this.h = null;
      this.i = null;
      this.j = null;
      this.g = true;
   }

   public id x_() {
      fn var1 = new fn();
      this.b(var1);
      return new iu(this.c, 6, var1);
   }

   public int b() {
      return this.a;
   }

   public static int b(amj var0) {
      fn var1 = var0.a("BlockEntityTag", false);
      return var1 != null && var1.c("Base")?var1.f("Base"):var0.i();
   }

   public static int c(amj var0) {
      fn var1 = var0.a("BlockEntityTag", false);
      return var1 != null && var1.c("Patterns")?var1.c("Patterns", 10).c():0;
   }

   public static void e(amj var0) {
      fn var1 = var0.a("BlockEntityTag", false);
      if(var1 != null && var1.b("Patterns", 9)) {
         fv var2 = var1.c("Patterns", 10);
         if(var2.c() > 0) {
            var2.a(var2.c() - 1);
            if(var2.c_()) {
               var0.o().o("BlockEntityTag");
               if(var0.o().c_()) {
                  var0.d((fn)null);
               }
            }

         }
      }
   }
}
