package net.minecraft.server;
import com.google.common.collect.Lists;

import java.util.ArrayList;

public class EntityPainting extends EntityHanging {

   public adn c;


   public EntityPainting(World var1) {
      super(var1);
   }

   public EntityPainting(World var1, Location var2, EnumFacing var3) {
      super(var1, var2);
      ArrayList var4 = Lists.newArrayList();
      adn[] var5 = adn.values();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         adn var8 = var5[var7];
         this.c = var8;
         this.a(var3);
         if(this.j()) {
            var4.add(var8);
         }
      }

      if(!var4.isEmpty()) {
         this.c = (adn)var4.get(this.V.nextInt(var4.size()));
      }

      this.a(var3);
   }

   public void b(NBTTagCompound var1) {
      var1.setString("Motive", this.c.B);
      super.b(var1);
   }

   public void a(NBTTagCompound var1) {
      String var2 = var1.getString("Motive");
      adn[] var3 = adn.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         adn var6 = var3[var5];
         if(var6.B.equals(var2)) {
            this.c = var6;
         }
      }

      if(this.c == null) {
         this.c = adn.a;
      }

      super.a(var1);
   }

   public int l() {
      return this.c.C;
   }

   public int m() {
      return this.c.D;
   }

   public void b(Entity var1) {
      if(this.o.Q().b("doTileDrops")) {
         if(var1 instanceof EntityHuman) {
            EntityHuman var2 = (EntityHuman)var1;
            if(var2.by.d) {
               return;
            }
         }

         this.a(new ItemStack(Items.an), 0.0F);
      }
   }

   public void setPositionRotation(double var1, double var3, double var5, float var7, float var8) {
      Location var9 = new Location(var1 - this.s, var3 - this.t, var5 - this.u);
      Location var10 = this.a.a((fd)var9);
      this.b((double)var10.n(), (double)var10.o(), (double)var10.p());
   }
}
