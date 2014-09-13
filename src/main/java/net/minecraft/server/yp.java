package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import java.util.List;

public class yp extends PathfinderGoal {

   public final Predicate a = new yq(this);
   protected EntityCreature b;
   private double d;
   private double e;
   protected Entity c;
   private float f;
   private bpv g;
   private aaz h;
   private Predicate i;


   public yp(EntityCreature var1, Predicate var2, float var3, double var4, double var6) {
      this.b = var1;
      this.i = var2;
      this.f = var3;
      this.d = var4;
      this.e = var6;
      this.h = var1.s();
      this.a(1);
   }

   public boolean a() {
      List var1 = this.b.o.a((Entity)this.b, this.b.aQ().b((double)this.f, 3.0D, (double)this.f), Predicates.and(new Predicate[]{xe.d, this.a, this.i}));
      if(var1.isEmpty()) {
         return false;
      } else {
         this.c = (Entity)var1.get(0);
         ChunkCoordinates var2 = abf.b(this.b, 16, 7, new ChunkCoordinates(this.c.s, this.c.t, this.c.u));
         if(var2 == null) {
            return false;
         } else if(this.c.e(var2.a, var2.b, var2.c) < this.c.h(this.b)) {
            return false;
         } else {
            this.g = this.h.a(var2.a, var2.b, var2.c);
            return this.g == null?false:this.g.b(var2);
         }
      }
   }

   public boolean b() {
      return !this.h.m();
   }

   public void c() {
      this.h.a(this.g, this.d);
   }

   public void d() {
      this.c = null;
   }

   public void e() {
      if(this.b.h(this.c) < 49.0D) {
         this.b.s().a(this.e);
      } else {
         this.b.s().a(this.d);
      }

   }
}
