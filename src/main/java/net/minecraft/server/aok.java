package net.minecraft.server;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class aok {

   private static final aok a = new aok();
   private Map b = Maps.newHashMap();
   private Map c = Maps.newHashMap();


   public static aok a() {
      return a;
   }

   private aok() {
      this.a(aty.p, new amj(Items.j), 0.7F);
      this.a(aty.o, new amj(Items.k), 1.0F);
      this.a(aty.ag, new amj(Items.i), 1.0F);
      this.a((Block)aty.m, new amj(aty.w), 0.1F);
      this.a(Items.al, new amj(Items.am), 0.35F);
      this.a(Items.bi, new amj(Items.bj), 0.35F);
      this.a(Items.bk, new amj(Items.bl), 0.35F);
      this.a(Items.bo, new amj(Items.bp), 0.35F);
      this.a(Items.bm, new amj(Items.bn), 0.35F);
      this.a(aty.e, new amj(aty.b), 0.1F);
      this.a(new amj(aty.bf, 1, bbc.b), new amj(aty.bf, 1, bbc.N), 0.1F);
      this.a(Items.aI, new amj(Items.aH), 0.3F);
      this.a(aty.aL, new amj(aty.cz), 0.35F);
      this.a((Block)aty.aK, new amj(Items.aW, 1, akv.n.b()), 0.2F);
      this.a(aty.r, new amj(Items.h, 1, 1), 0.15F);
      this.a(aty.s, new amj(Items.h, 1, 1), 0.15F);
      this.a(aty.bP, new amj(Items.bO), 1.0F);
      this.a(Items.bS, new amj(Items.bT), 0.35F);
      this.a(aty.aV, new amj(Items.cf), 0.1F);
      this.a(new amj(aty.v, 1, 1), new amj(aty.v, 1, 0), 0.15F);
      ali[] var1 = ali.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         ali var4 = var1[var3];
         if(var4.g()) {
            this.a(new amj(Items.aU, 1, var4.a()), new amj(Items.aV, 1, var4.a()), 0.35F);
         }
      }

      this.a(aty.q, new amj(Items.h), 0.1F);
      this.a(aty.aC, new amj(Items.aC), 0.7F);
      this.a(aty.x, new amj(Items.aW, 1, akv.l.b()), 0.2F);
      this.a(aty.co, new amj(Items.cg), 0.2F);
   }

   public void a(Block var1, amj var2, float var3) {
      this.a(alq.a(var1), var2, var3);
   }

   public void a(alq var1, amj var2, float var3) {
      this.a(new amj(var1, 1, 32767), var2, var3);
   }

   public void a(amj var1, amj var2, float var3) {
      this.b.put(var1, var2);
      this.c.put(var2, Float.valueOf(var3));
   }

   public amj a(amj var1) {
      Iterator var2 = this.b.entrySet().iterator();

      Entry var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (Entry)var2.next();
      } while(!this.a(var1, (amj)var3.getKey()));

      return (amj)var3.getValue();
   }

   private boolean a(amj var1, amj var2) {
      return var2.b() == var1.b() && (var2.i() == 32767 || var2.i() == var1.i());
   }

   public Map b() {
      return this.b;
   }

   public float b(amj var1) {
      Iterator var2 = this.c.entrySet().iterator();

      Entry var3;
      do {
         if(!var2.hasNext()) {
            return 0.0F;
         }

         var3 = (Entry)var2.next();
      } while(!this.a(var1, (amj)var3.getKey()));

      return ((Float)var3.getValue()).floatValue();
   }

}
