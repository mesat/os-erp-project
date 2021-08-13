export default [{
    _name: "CSidebarNav",
    _children: [
        {
            _name: "CSidebarNavItem",
            name: "+ New Employee",
            _class: "bg-success",
            to: "/new",
        }, {
            _name: "CSidebarNavItem",
            name: "Employees",
            to: "/employees",

        }, {
            _name: "CSidebarNavItem",
            name: "Create Team",
            to: "/teams",
        }, {
            _name: "CSidebarNavItem",
            name: "VueTest",
            to: "/test",
        }, {
            _name: "CSidebarNavItem",
            name: "Create Social Media",
            to: "/social",
        }

    ]
}
]