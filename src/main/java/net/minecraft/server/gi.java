package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

class gi extends gh {

   protected List b = Lists.newArrayList();


   public gi(String var1) {
      this.a = var1;
   }

   public NBTBase a() {
      NBTTagCompound var1 = new NBTTagCompound();
      Iterator var2 = this.b.iterator();

      while(var2.hasNext()) {
         gh var3 = (gh)var2.next();
         var1.a(var3.a, var3.a());
      }

      return var1;
   }
}
