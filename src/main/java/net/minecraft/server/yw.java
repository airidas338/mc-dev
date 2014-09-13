package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class yw extends PathfinderGoal {

   private static final Predicate b = beq.a((Block)Blocks.H).a(BlockLongGrass.a, Predicates.equalTo(EnumFoliage.b));
   private EntityInsentient c;
   private World d;
   int a;


   public yw(EntityInsentient var1) {
      this.c = var1;
      this.d = var1.o;
      this.a(7);
   }

   public boolean a() {
      if(this.c.bb().nextInt(this.c.i_()?50:1000) != 0) {
         return false;
      } else {
         Location var1 = new Location(this.c.s, this.c.t, this.c.u);
         return b.apply(this.d.getData(var1))?true:this.d.getData(var1.b()).c() == Blocks.c;
      }
   }

   public void c() {
      this.a = 40;
      this.d.a((Entity)this.c, (byte)10);
      this.c.getNavigation().n();
   }

   public void d() {
      this.a = 0;
   }

   public boolean b() {
      return this.a > 0;
   }

   public int f() {
      return this.a;
   }

   public void e() {
      this.a = Math.max(0, this.a - 1);
      if(this.a == 4) {
         Location var1 = new Location(this.c.s, this.c.t, this.c.u);
         if(b.apply(this.d.getData(var1))) {
            if(this.d.Q().b("mobGriefing")) {
               this.d.b(var1, false);
            }

            this.c.v();
         } else {
            Location var2 = var1.b();
            if(this.d.getData(var2).c() == Blocks.c) {
               if(this.d.Q().b("mobGriefing")) {
                  this.d.b(2001, var2, Block.a((Block)Blocks.c));
                  this.d.a(var2, Blocks.d.P(), 2);
               }

               this.c.v();
            }
         }

      }
   }

}
