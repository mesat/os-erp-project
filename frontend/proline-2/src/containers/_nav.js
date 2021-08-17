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
            name: "Manage Employees",
            to: "/employees",

        }, {
            _name: "CSidebarNavItem",
            name: "Manage Teams",
            to: "/teams",
        }, {
            _name: "CSidebarNavItem",
            name: "Manage Social Media",
            to: "/social",
        }

    ]
}
]