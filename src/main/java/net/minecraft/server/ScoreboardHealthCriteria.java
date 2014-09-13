package net.minecraft.server;
import java.util.Iterator;
import java.util.List;

public class ScoreboardHealthCriteria extends ScoreboardBaseCriteria {

   public ScoreboardHealthCriteria(String var1) {
      super(var1);
   }

   public int a(List var1) {
      float var2 = 0.0F;

      EntityHuman var4;
      for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 += var4.bm() + var4.bM()) {
         var4 = (EntityHuman)var3.next();
      }

      if(var1.size() > 0) {
         var2 /= (float)var1.size();
      }

      return MathHelper.f(var2);
   }

   public boolean isReadOnly() {
      return true;
   }

   public EnumObjectiveValue c() {
      return EnumObjectiveValue.HEARTS;
   }
}
