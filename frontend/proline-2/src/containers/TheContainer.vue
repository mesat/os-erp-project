<template>
  <div class="c-app">
    <TheSidebar/>
    <CWrapper>
      <div class="c-body">
        <main>
          <CContainer fluid>
            <transition name="fade" mode="out-in">
              <RouterView/>
            </transition>
          </CContainer>
        </main>
      </div>
    </CWrapper>
  </div>
</template>

<script>
import TheSidebar from "./TheSidebar";
export default {
  name: "TheContainer",
  components: {
    TheSidebar
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