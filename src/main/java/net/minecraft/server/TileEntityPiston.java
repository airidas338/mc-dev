package net.minecraft.server;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

public class TileEntityPiston extends TileEntity implements IUpdatePlayerListBox {

   private IBlockData a;
   private EnumFacing f;
   private boolean g;
   private boolean h;
   private float i;
   private float j;
   private List k = Lists.newArrayList();


   public TileEntityPiston() {}

   public TileEntityPiston(IBlockData var1, EnumFacing var2, boolean var3, boolean var4) {
      this.a = var1;
      this.f = var2;
      this.g = var3;
      this.h = var4;
   }

   public IBlockData b() {
      return this.a;
   }

   public int u() {
      return 0;
   }

   public boolean d() {
      return this.g;
   }

   public EnumFacing e() {
      return this.f;
   }

   public float a(float var1) {
      if(var1 > 1.0F) {
         var1 = 1.0F;
      }

      return this.j + (this.i - this.j) * var1;
   }

   private void a(float var1, float var2) {
      if(this.g) {
         var1 = 1.0F - var1;
      } else {
         --var1;
      }

      AxisAlignedBB var3 = Blocks.PISTON_MOVING.a(this.b, this.c, this.a, var1, this.f);
      if(var3 != null) {
         List var4 = this.b.b((Entity)null, var3);
         if(!var4.isEmpty()) {
            this.k.addAll(var4);
            Iterator var5 = this.k.iterator();

            while(var5.hasNext()) {
               Entity var6 = (Entity)var5.next();
               if(this.a.c() == Blocks.SLIME && this.g) {
                  switch(bdw.a[this.f.k().ordinal()]) {
                  case 1:
                     var6.v = (double)this.f.g();
                     break;
                  case 2:
                     var6.w = (double)this.f.h();
                     break;
                  case 3:
                     var6.x = (double)this.f.i();
                  }
               } else {
                  var6.d((double)(var2 * (float)this.f.g()), (double)(var2 * (float)this.f.h()), (double)(var2 * (float)this.f.i()));
               }
            }

            this.k.clear();
         }
      }

   }

   public void h() {
      if(this.j < 1.0F && this.b != null) {
         this.j = this.i = 1.0F;
         this.b.t(this.c);
         this.y();
         if(this.b.getData(this.c).c() == Blocks.PISTON_MOVING) {
            this.b.a(this.c, this.a, 3);
            this.b.d(this.c, this.a.c());
         }
      }

   }

   public void c() {
      this.j = this.i;
      if(this.j >= 1.0F) {
         this.a(1.0F, 0.25F);
         this.b.t(this.c);
         this.y();
         if(this.b.getData(this.c).c() == Blocks.PISTON_MOVING) {
            this.b.a(this.c, this.a, 3);
            this.b.d(this.c, this.a.c());
         }

      } else {
         this.i += 0.5F;
         if(this.i >= 1.0F) {
            this.i = 1.0F;
         }

         if(this.g) {
            this.a(this.i, this.i - this.j + 0.0625F);
         }

      }
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.a = Block.c(var1.getInt("blockId")).a(var1.getInt("blockData"));
      this.f = EnumFacing.a(var1.getInt("facing"));
      this.j = this.i = var1.getFloat("progress");
      this.g = var1.getBoolean("extending");
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.setInt("blockId", Block.getId(this.a.c()));
      var1.setInt("blockData", this.a.c().c(this.a));
      var1.setInt("facing", this.f.a());
      var1.setFloat("progress", this.j);
      var1.setBoolean("extending", this.g);
   }
}
