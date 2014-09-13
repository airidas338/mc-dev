package net.minecraft.server;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class abi {

   private World a;
   private final List b = Lists.newArrayList();
   private Location c;
   private Location d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private TreeMap j;
   private List k;
   private int l;


   public abi() {
      this.c = Location.a;
      this.d = Location.a;
      this.j = new TreeMap();
      this.k = Lists.newArrayList();
   }

   public abi(World var1) {
      this.c = Location.a;
      this.d = Location.a;
      this.j = new TreeMap();
      this.k = Lists.newArrayList();
      this.a = var1;
   }

   public void a(World var1) {
      this.a = var1;
   }

   public void a(int var1) {
      this.g = var1;
      this.m();
      this.l();
      if(var1 % 20 == 0) {
         this.k();
      }

      if(var1 % 30 == 0) {
         this.j();
      }

      int var2 = this.h / 10;
      if(this.l < var2 && this.b.size() > 20 && this.a.s.nextInt(7000) == 0) {
         ChunkCoordinates var3 = this.a(this.d, 2, 4, 2);
         if(var3 != null) {
            EntityIronGolem var4 = new EntityIronGolem(this.a);
            var4.b(var3.a, var3.b, var3.c);
            this.a.d((Entity)var4);
            ++this.l;
         }
      }

   }

   private ChunkCoordinates a(Location var1, int var2, int var3, int var4) {
      for(int var5 = 0; var5 < 10; ++var5) {
         Location var6 = var1.a(this.a.s.nextInt(16) - 8, this.a.s.nextInt(6) - 3, this.a.s.nextInt(16) - 8);
         if(this.a(var6) && this.a(new Location(var2, var3, var4), var6)) {
            return new ChunkCoordinates((double)var6.n(), (double)var6.o(), (double)var6.p());
         }
      }

      return null;
   }

   private boolean a(Location var1, Location var2) {
      if(!World.a((IBlockAccess)this.a, var2.b())) {
         return false;
      } else {
         int var3 = var2.n() - var1.n() / 2;
         int var4 = var2.p() - var1.p() / 2;

         for(int var5 = var3; var5 < var3 + var1.n(); ++var5) {
            for(int var6 = var2.o(); var6 < var2.o() + var1.o(); ++var6) {
               for(int var7 = var4; var7 < var4 + var1.p(); ++var7) {
                  if(this.a.getData(new Location(var5, var6, var7)).c().t()) {
                     return false;
                  }
               }
            }
         }

         return true;
      }
   }

   private void j() {
      List var1 = this.a.a(EntityIronGolem.class, new AxisAlignedBB((double)(this.d.n() - this.e), (double)(this.d.o() - 4), (double)(this.d.p() - this.e), (double)(this.d.n() + this.e), (double)(this.d.o() + 4), (double)(this.d.p() + this.e)));
      this.l = var1.size();
   }

   private void k() {
      List var1 = this.a.a(EntityVillager.class, new AxisAlignedBB((double)(this.d.n() - this.e), (double)(this.d.o() - 4), (double)(this.d.p() - this.e), (double)(this.d.n() + this.e), (double)(this.d.o() + 4), (double)(this.d.p() + this.e)));
      this.h = var1.size();
      if(this.h == 0) {
         this.j.clear();
      }

   }

   public Location a() {
      return this.d;
   }

   public int b() {
      return this.e;
   }

   public int c() {
      return this.b.size();
   }

   public int d() {
      return this.g - this.f;
   }

   public int e() {
      return this.h;
   }

   public boolean a(Location var1) {
      return this.d.i(var1) < (double)(this.e * this.e);
   }

   public List f() {
      return this.b;
   }

   public abh b(Location var1) {
      abh var2 = null;
      int var3 = Integer.MAX_VALUE;
      Iterator var4 = this.b.iterator();

      while(var4.hasNext()) {
         abh var5 = (abh)var4.next();
         int var6 = var5.a(var1);
         if(var6 < var3) {
            var2 = var5;
            var3 = var6;
         }
      }

      return var2;
   }

   public abh c(Location var1) {
      abh var2 = null;
      int var3 = Integer.MAX_VALUE;
      Iterator var4 = this.b.iterator();

      while(var4.hasNext()) {
         abh var5 = (abh)var4.next();
         int var6 = var5.a(var1);
         if(var6 > 256) {
            var6 *= 1000;
         } else {
            var6 = var5.c();
         }

         if(var6 < var3) {
            var2 = var5;
            var3 = var6;
         }
      }

      return var2;
   }

   public abh e(Location var1) {
      if(this.d.i(var1) > (double)(this.e * this.e)) {
         return null;
      } else {
         Iterator var2 = this.b.iterator();

         abh var3;
         do {
            if(!var2.hasNext()) {
               return null;
            }

            var3 = (abh)var2.next();
         } while(var3.d().n() != var1.n() || var3.d().p() != var1.p() || Math.abs(var3.d().o() - var1.o()) > 1);

         return var3;
      }
   }

   public void a(abh var1) {
      this.b.add(var1);
      this.c = this.c.a((fd)var1.d());
      this.n();
      this.f = var1.h();
   }

   public boolean g() {
      return this.b.isEmpty();
   }

   public void a(EntityLiving var1) {
      Iterator var2 = this.k.iterator();

      abj var3;
      do {
         if(!var2.hasNext()) {
            this.k.add(new abj(this, var1, this.g));
            return;
         }

         var3 = (abj)var2.next();
      } while(var3.a != var1);

      var3.b = this.g;
   }

   public EntityLiving b(EntityLiving var1) {
      double var2 = Double.MAX_VALUE;
      abj var4 = null;

      for(int var5 = 0; var5 < this.k.size(); ++var5) {
         abj var6 = (abj)this.k.get(var5);
         double var7 = var6.a.h(var1);
         if(var7 <= var2) {
            var4 = var6;
            var2 = var7;
         }
      }

      return var4 != null?var4.a:null;
   }

   public EntityHuman c(EntityLiving var1) {
      double var2 = Double.MAX_VALUE;
      EntityHuman var4 = null;
      Iterator var5 = this.j.keySet().iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();
         if(this.d(var6)) {
            EntityHuman var7 = this.a.a(var6);
            if(var7 != null) {
               double var8 = var7.h(var1);
               if(var8 <= var2) {
                  var4 = var7;
                  var2 = var8;
               }
            }
         }
      }

      return var4;
   }

   private void l() {
      Iterator var1 = this.k.iterator();

      while(var1.hasNext()) {
         abj var2 = (abj)var1.next();
         if(!var2.a.ai() || Math.abs(this.g - var2.b) > 300) {
            var1.remove();
         }
      }

   }

   private void m() {
      boolean var1 = false;
      boolean var2 = this.a.s.nextInt(50) == 0;
      Iterator var3 = this.b.iterator();

      while(var3.hasNext()) {
         abh var4 = (abh)var3.next();
         if(var2) {
            var4.a();
         }

         if(!this.f(var4.d()) || Math.abs(this.g - var4.h()) > 1200) {
            this.c = this.c.a((fd)var4.d().a(-1));
            var1 = true;
            var4.a(true);
            var3.remove();
         }
      }

      if(var1) {
         this.n();
      }

   }

   private boolean f(Location var1) {
      Block var2 = this.a.getData(var1).c();
      return var2 instanceof BlockDoor?var2.r() == Material.WOOD:false;
   }

   private void n() {
      int var1 = this.b.size();
      if(var1 == 0) {
         this.d = new Location(0, 0, 0);
         this.e = 0;
      } else {
         this.d = new Location(this.c.n() / var1, this.c.o() / var1, this.c.p() / var1);
         int var2 = 0;

         abh var4;
         for(Iterator var3 = this.b.iterator(); var3.hasNext(); var2 = Math.max(var4.a(this.d), var2)) {
            var4 = (abh)var3.next();
         }

         this.e = Math.max(32, (int)Math.sqrt((double)var2) + 1);
      }
   }

   public int a(String var1) {
      Integer var2 = (Integer)this.j.get(var1);
      return var2 != null?var2.intValue():0;
   }

   public int a(String var1, int var2) {
      int var3 = this.a(var1);
      int var4 = MathHelper.a(var3 + var2, -30, 10);
      this.j.put(var1, Integer.valueOf(var4));
      return var4;
   }

   public boolean d(String var1) {
      return this.a(var1) <= -15;
   }

   public void a(NBTTagCompound var1) {
      this.h = var1.f("PopSize");
      this.e = var1.f("Radius");
      this.l = var1.f("Golems");
      this.f = var1.f("Stable");
      this.g = var1.f("Tick");
      this.i = var1.f("MTick");
      this.d = new Location(var1.f("CX"), var1.f("CY"), var1.f("CZ"));
      this.c = new Location(var1.f("ACX"), var1.f("ACY"), var1.f("ACZ"));
      fv var2 = var1.c("Doors", 10);

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         NBTTagCompound var4 = var2.b(var3);
         abh var5 = new abh(new Location(var4.f("X"), var4.f("Y"), var4.f("Z")), var4.f("IDX"), var4.f("IDZ"), var4.f("TS"));
         this.b.add(var5);
      }

      fv var6 = var1.c("Players", 10);

      for(int var7 = 0; var7 < var6.c(); ++var7) {
         NBTTagCompound var8 = var6.b(var7);
         this.j.put(var8.j("Name"), Integer.valueOf(var8.f("S")));
      }

   }

   public void b(NBTTagCompound var1) {
      var1.a("PopSize", this.h);
      var1.a("Radius", this.e);
      var1.a("Golems", this.l);
      var1.a("Stable", this.f);
      var1.a("Tick", this.g);
      var1.a("MTick", this.i);
      var1.a("CX", this.d.n());
      var1.a("CY", this.d.o());
      var1.a("CZ", this.d.p());
      var1.a("ACX", this.c.n());
      var1.a("ACY", this.c.o());
      var1.a("ACZ", this.c.p());
      fv var2 = new fv();
      Iterator var3 = this.b.iterator();

      while(var3.hasNext()) {
         abh var4 = (abh)var3.next();
         NBTTagCompound var5 = new NBTTagCompound();
         var5.a("X", var4.d().n());
         var5.a("Y", var4.d().o());
         var5.a("Z", var4.d().p());
         var5.a("IDX", var4.f());
         var5.a("IDZ", var4.g());
         var5.a("TS", var4.h());
         var2.a((NBTBase)var5);
      }

      var1.a("Doors", (NBTBase)var2);
      fv var7 = new fv();
      Iterator var8 = this.j.keySet().iterator();

      while(var8.hasNext()) {
         String var9 = (String)var8.next();
         NBTTagCompound var6 = new NBTTagCompound();
         var6.a("Name", var9);
         var6.a("S", ((Integer)this.j.get(var9)).intValue());
         var7.a((NBTBase)var6);
      }

      var1.a("Players", (NBTBase)var7);
   }

   public void h() {
      this.i = this.g;
   }

   public boolean i() {
      return this.i == 0 || this.g - this.i >= 3600;
   }

   public void b(int var1) {
      Iterator var2 = this.j.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         this.a(var3, var1);
      }

   }
}
