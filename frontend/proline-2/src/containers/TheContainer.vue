<template>
  <div class="c-app">
    <TheSidebar :minimized="minimized"/>
    <CWrapper>
      <TheHeader @toggle="minimize"/>
      <div class="c-body">
        <main class="c-main">
          <CContainer fluid>
            <transition name="fade" mode="out-in">
              <RouterView/>
            </transition>
          </CContainer>
        </main>
      </div>
      <TheFooter/>
    </CWrapper>
  </div>
</template>

<script>
import TheSidebar from "./TheSidebar";
import TheHeader from "./TheHeader";
import TheFooter from "./TheFooter";

export default {
  name: "TheContainer",
  data() {
    return {
      minimized: false
    }
  },
  methods: {
    minimize() {
      if (this.minimized) {
        this.minimized = false
      } else {
        this.minimized = true
      }
    }
  },
  components: {
    TheSidebar,
    TheHeader,
    TheFooter
  }
}
</script>

<style scoped>
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.3s;
}

.fade-enter,
.fade-leave-to {
  opacity: 0;
}
</style>