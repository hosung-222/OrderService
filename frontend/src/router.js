
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderOrderManager from "./components/listers/OrderOrderCards"
import OrderOrderDetail from "./components/listers/OrderOrderDetail"

import DeliveryShippingManager from "./components/listers/DeliveryShippingCards"
import DeliveryShippingDetail from "./components/listers/DeliveryShippingDetail"

import InventoryStockManager from "./components/listers/InventoryStockCards"
import InventoryStockDetail from "./components/listers/InventoryStockDetail"




export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders/orders',
                name: 'OrderOrderManager',
                component: OrderOrderManager
            },
            {
                path: '/orders/orders/:id',
                name: 'OrderOrderDetail',
                component: OrderOrderDetail
            },

            {
                path: '/deliveries/shippings',
                name: 'DeliveryShippingManager',
                component: DeliveryShippingManager
            },
            {
                path: '/deliveries/shippings/:id',
                name: 'DeliveryShippingDetail',
                component: DeliveryShippingDetail
            },

            {
                path: '/inventories/stocks',
                name: 'InventoryStockManager',
                component: InventoryStockManager
            },
            {
                path: '/inventories/stocks/:id',
                name: 'InventoryStockDetail',
                component: InventoryStockDetail
            },





    ]
})
