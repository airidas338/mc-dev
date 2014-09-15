package net.minecraft.server;
import java.util.List;

public class TileEntityBanner extends TileEntity {

   private int a;
   private NBTTagList f;
   private boolean g;
   private List h;
   private List i;
   private String j;


   public void a(ItemStack var1) {
      this.f = null;
      if(var1.n() && var1.o().hasKeyOfType("BlockEntityTag", 10)) {
         NBTTagCompound var2 = var1.o().getCompound("BlockEntityTag");
         if(var2.hasKey("Patterns")) {
            this.f = (NBTTagList)var2.getList("Patterns", 10).b();
         }

         if(var2.hasKeyOfType("Base", 99)) {
            this.a = var2.getInt("Base");
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

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.setInt("Base", this.a);
      if(this.f != null) {
         var1.set("Patterns", (NBTBase)this.f);
      }

   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.a = var1.getInt("Base");
      this.f = var1.getList("Patterns", 10);
      this.h = null;
      this.i = null;
      this.j = null;
      this.g = true;
   }

   public Packet x_() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.b(var1);
      return new iu(this.c, 6, var1);
   }

   public int b() {
      return this.a;
   }

   public static int b(ItemStack var0) {
      NBTTagCompound var1 = var0.a("BlockEntityTag", false);
      return var1 != null && var1.hasKey("Base")?var1.getInt("Base"):var0.i();
   }

   public static int c(ItemStack var0) {
      NBTTagCompound var1 = var0.a("BlockEntityTag", false);
      return var1 != null && var1.hasKey("Patterns")?var1.getList("Patterns", 10).c():0;
   }

   public static void e(ItemStack var0) {
      NBTTagCompound var1 = var0.a("BlockEntityTag", false);
      if(var1 != null && var1.hasKeyOfType("Patterns", 9)) {
         NBTTagList var2 = var1.getList("Patterns", 10);
         if(var2.c() > 0) {
            var2.a(var2.c() - 1);
            if(var2.c_()) {
               var0.o().o("BlockEntityTag");
               if(var0.o().c_()) {
                  var0.d((NBTTagCompound)null);
               }
            }

         }
      }
   }
}
