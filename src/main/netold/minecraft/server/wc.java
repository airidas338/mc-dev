package net.minecraft.server;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

class wc extends TimerTask {

   // $FF: synthetic field
   final wb a;


   wc(wb var1) {
      this.a = var1;
   }

   public void run() {
      if(wb.a(this.a).ac()) {
         HashMap var1;
         synchronized(wb.b(this.a)) {
            var1 = Maps.newHashMap(wb.c(this.a));
            if(wb.d(this.a) == 0) {
               var1.putAll(wb.e(this.a));
            }

            var1.put("snooper_count", Integer.valueOf(wb.f(this.a)));
            var1.put("snooper_token", wb.g(this.a));
         }

         ui.a(wb.h(this.a), (Map)var1, true);
      }
   }
}
