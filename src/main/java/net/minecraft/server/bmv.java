package net.minecraft.server;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public abstract class bmv {

   protected LinkedList a = new LinkedList();
   protected bjb b;
   private int c;
   private int d;


   public bmv() {}

   public bmv(int var1, int var2) {
      this.c = var1;
      this.d = var2;
   }

   public bjb a() {
      return this.b;
   }

   public LinkedList b() {
      return this.a;
   }

   public void a(World var1, Random var2, bjb var3) {
      Iterator var4 = this.a.iterator();

      while(var4.hasNext()) {
         bms var5 = (bms)var4.next();
         if(var5.c().a(var3) && !var5.a(var1, var2, var3)) {
            var4.remove();
         }
      }

   }

   protected void c() {
      this.b = bjb.a();
      Iterator var1 = this.a.iterator();

      while(var1.hasNext()) {
         bms var2 = (bms)var1.next();
         this.b.b(var2.c());
      }

   }

   public NBTTagCompound a(int var1, int var2) {
      NBTTagCompound var3 = new NBTTagCompound();
      var3.a("id", bmq.a(this));
      var3.a("ChunkX", var1);
      var3.a("ChunkZ", var2);
      var3.a("BB", (NBTBase)this.b.g());
      fv var4 = new fv();
      Iterator var5 = this.a.iterator();

      while(var5.hasNext()) {
         bms var6 = (bms)var5.next();
         var4.a((NBTBase)var6.b());
      }

      var3.a("Children", (NBTBase)var4);
      this.a(var3);
      return var3;
   }

   public void a(NBTTagCompound var1) {}

   public void a(World var1, NBTTagCompound var2) {
      this.c = var2.f("ChunkX");
      this.d = var2.f("ChunkZ");
      if(var2.c("BB")) {
         this.b = new bjb(var2.l("BB"));
      }

      fv var3 = var2.c("Children", 10);

      for(int var4 = 0; var4 < var3.c(); ++var4) {
         this.a.add(bmq.b(var3.b(var4), var1));
      }

      this.b(var2);
   }

   public void b(NBTTagCompound var1) {}

   protected void a(World var1, Random var2, int var3) {
      int var4 = 63 - var3;
      int var5 = this.b.d() + 1;
      if(var5 < var4) {
         var5 += var2.nextInt(var4 - var5);
      }

      int var6 = var5 - this.b.e;
      this.b.a(0, var6, 0);
      Iterator var7 = this.a.iterator();

      while(var7.hasNext()) {
         bms var8 = (bms)var7.next();
         var8.c().a(0, var6, 0);
      }

   }

   protected void a(World var1, Random var2, int var3, int var4) {
      int var5 = var4 - var3 + 1 - this.b.d();
      boolean var6 = true;
      int var10;
      if(var5 > 1) {
         var10 = var3 + var2.nextInt(var5);
      } else {
         var10 = var3;
      }

      int var7 = var10 - this.b.b;
      this.b.a(0, var7, 0);
      Iterator var8 = this.a.iterator();

      while(var8.hasNext()) {
         bms var9 = (bms)var8.next();
         var9.c().a(0, var7, 0);
      }

   }

   public boolean d() {
      return true;
   }

   public boolean a(aqm var1) {
      return true;
   }

   public void b(aqm var1) {}

   public int e() {
      return this.c;
   }

   public int f() {
      return this.d;
   }
}
