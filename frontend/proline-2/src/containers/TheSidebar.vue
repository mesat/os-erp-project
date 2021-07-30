<template>
  <CSidebar fixed>
    <CRenderFunction flat :content-to-render="$options.nav"/>
  </CSidebar>
</template>

<script>
import nav from "./_nav"
export default {
  name: "TheSidebar",
  nav
}
</script>

<style scoped>

</style>