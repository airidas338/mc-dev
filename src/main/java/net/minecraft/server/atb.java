package net.minecraft.server;
import com.google.common.base.Predicate;
import java.util.Random;

public class atb extends atg {

   public static final beu a = beu.a("facing", (Predicate)en.a);
   public static final bew b = bew.a("rotation", 0, 15);


   protected atb() {
      super(Material.WOOD);
      float var1 = 0.25F;
      float var2 = 1.0F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
   }

   public AxisAlignedBB a(World var1, Location var2, IBlockData var3) {
      return null;
   }

   public boolean d() {
      return false;
   }

   public boolean b(IBlockAccess var1, Location var2) {
      return true;
   }

   public boolean c() {
      return false;
   }

   public TileEntity a(World var1, int var2) {
      return new bci();
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return Items.cE;
   }

   public void a(World var1, Location var2, IBlockData var3, float var4, int var5) {
      TileEntity var6 = var1.s(var2);
      if(var6 instanceof bci) {
         ItemStack var7 = new ItemStack(Items.cE, 1, ((bci)var6).b());
         NBTTagCompound var8 = new NBTTagCompound();
         var6.b(var8);
         var8.o("x");
         var8.o("y");
         var8.o("z");
         var8.o("id");
         var7.a("BlockEntityTag", (NBTBase)var8);
         a(var1, var2, var7);
      } else {
         super.a(var1, var2, var3, var4, var5);
      }

   }

   public void a(World var1, EntityHuman var2, Location var3, IBlockData var4, TileEntity var5) {
      if(var5 instanceof bci) {
         ItemStack var6 = new ItemStack(Items.cE, 1, ((bci)var5).b());
         NBTTagCompound var7 = new NBTTagCompound();
         var5.b(var7);
         var7.o("x");
         var7.o("y");
         var7.o("z");
         var7.o("id");
         var6.a("BlockEntityTag", (NBTBase)var7);
         a(var1, var3, var6);
      } else {
         super.a(var1, var2, var3, var4, (TileEntity)null);
      }

   }

}
