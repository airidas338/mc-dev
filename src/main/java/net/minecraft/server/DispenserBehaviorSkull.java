package net.minecraft.server;
import com.mojang.authlib.GameProfile;
import java.util.UUID;

final class DispenserBehaviorSkull extends DispenserBehaviorItem {

   private boolean b = true;


   protected ItemStack b(ISourceBlock var1, ItemStack var2) {
      World var3 = var1.i();
      EnumFacing var4 = BlockDispenser.b(var1.f());
      Location var5 = var1.d().a(var4);
      BlockSkull var6 = Blocks.SKULL;
      if(var3.isEmpty(var5) && var6.b(var3, var5, var2)) {
         if(!var3.isStatic) {
            var3.setTypeAndData(var5, var6.P().a(BlockSkull.a, EnumFacing.UP), 3);
            TileEntity var7 = var3.getTileEntity(var5);
            if(var7 instanceof TileEntitySkull) {
               if(var2.i() == 3) {
                  GameProfile var8 = null;
                  if(var2.n()) {
                     NBTTagCompound var9 = var2.o();
                     if(var9.hasKeyOfType("SkullOwner", 10)) {
                        var8 = GameProfileSerializer.deserialize(var9.getCompound("SkullOwner"));
                     } else if(var9.hasKeyOfType("SkullOwner", 8)) {
                        var8 = new GameProfile((UUID)null, var9.getString("SkullOwner"));
                     }
                  }

                  ((TileEntitySkull)var7).a(var8);
               } else {
                  ((TileEntitySkull)var7).a(var2.i());
               }

               ((TileEntitySkull)var7).b(var4.d().b() * 4);
               Blocks.SKULL.a(var3, var5, (TileEntitySkull)var7);
            }

            --var2.b;
         }
      } else {
         this.b = false;
      }

      return var2;
   }

   protected void a(ISourceBlock var1) {
      if(this.b) {
         var1.i().triggerEffect(1000, var1.d(), 0);
      } else {
         var1.i().triggerEffect(1001, var1.d(), 0);
      }

   }
}
