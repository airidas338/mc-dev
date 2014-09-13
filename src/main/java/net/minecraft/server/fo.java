package net.minecraft.server;
import java.util.concurrent.Callable;

class fo implements Callable {

   // $FF: synthetic field
   final String a;
   // $FF: synthetic field
   final NBTTagCompound b;


   fo(NBTTagCompound var1, String var2) {
      this.b = var1;
      this.a = var2;
   }

   public String a() {
      return NBTBase.a[((NBTBase)NBTTagCompound.b(this.b).get(this.a)).getTypeId()];
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
