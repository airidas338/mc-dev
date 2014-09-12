package net.minecraft.server;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

class wc extends TimerTask {

   // $FF: synthetic field
   final MojangStatisticsGenerator a;


   wc(MojangStatisticsGenerator var1) {
      this.a = var1;
   }

   public void run() {
      if(MojangStatisticsGenerator.a(this.a).ac()) {
         HashMap var1;
         synchronized(MojangStatisticsGenerator.b(this.a)) {
            var1 = Maps.newHashMap(MojangStatisticsGenerator.c(this.a));
            if(MojangStatisticsGenerator.d(this.a) == 0) {
               var1.putAll(MojangStatisticsGenerator.e(this.a));
            }

            var1.put("snooper_count", Integer.valueOf(MojangStatisticsGenerator.f(this.a)));
            var1.put("snooper_token", MojangStatisticsGenerator.g(this.a));
         }

         ui.a(MojangStatisticsGenerator.h(this.a), (Map)var1, true);
      }
   }
}
