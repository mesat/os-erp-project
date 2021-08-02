<template>
  <CSidebar fixed :minimize="minimized" :show="!minimized">
    <CRenderFunction flat :content-to-render="$options.nav"/>
  </CSidebar>
</template>

<script>
import nav from "./_nav"

export default {
  name: "TheSidebar",
  props: ['minimized'],
  nav
}
</script>

<style scoped>

</style>