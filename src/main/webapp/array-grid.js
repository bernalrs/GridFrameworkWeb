Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.util.*',
    'Ext.state.*'
]);

// Define Company entity
// Null out built in convert functions for performance *because the raw data is known to be valid*
// Specifying defaultValue as undefined will also save code. *As long as there will always be values in the data, or the app tolerates undefined field values*
Ext.define('Company', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'company'},
        {name: 'symbol'},
        {name: 'sector'},
        {name: 'industry'},
        {name: 'lastPrice',      type: 'float', convert: null,     defaultValue: undefined},
        {name: 'quantity',   type: 'float', convert: null,     defaultValue: undefined},
        {name: 'openPrice', type: 'float', convert: null,     defaultValue: undefined},
        {name: 'change',     type: 'float', convert: null,     defaultValue: undefined},
        {name: 'changePercentage',  type: 'float', convert: null,     defaultValue: undefined},
        {name: 'gain',     type: 'float', convert: null,     defaultValue: undefined},
        {name: 'gainPercentage',  type: 'float', convert: null,     defaultValue: undefined},
        {name: 'lastChange', type: 'date',  dateFormat: 'n/j h:ia', defaultValue: undefined},
        {name: 'costBasis',      type: 'float', convert: null,     defaultValue: undefined},
        {name: 'marketValue',      type: 'float', convert: null,     defaultValue: undefined},
        {name: 'overallReturn',      type: 'float', convert: null,     defaultValue: undefined},
        {name: 'purchasedPrice',      type: 'float', convert: null,     defaultValue: undefined},
        {name: 'marketCap',      type: 'float', convert: null,     defaultValue: undefined},
        {name: 'averageVolume',      type: 'float', convert: null,     defaultValue: undefined},
        {name: 'weekHigh52',      type: 'float', convert: null,     defaultValue: undefined},
        {name: 'weekLow52',      type: 'float', convert: null,     defaultValue: undefined},
        {name: 'earningsPerShare',      type: 'float', convert: null,     defaultValue: undefined},
        {name: 'priceEarningsRatio',      type: 'float', convert: null,     defaultValue: undefined},
        {name: 'beta',      type: 'float', convert: null,     defaultValue: undefined},


    ],
    idProperty: 'company'
});

Ext.onReady(function() {

    Ext.QuickTips.init();

    // setup the state provider, all state information will be saved to a cookie
    Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));

    /**
     * Custom function used for column renderer
     * @param {Object} val
     */
    function price(val, rec) {
        var value = Math.round(val*Math.pow(10,2))/Math.pow(10,2);
        return '<div style="color:blue;font-weight:500;">' + value + '</div>';
    }

    /**
     * Custom function used for column renderer
     * @param {Object} val
     */
    function change(val) {
        var value = Math.round(val*Math.pow(10,2))/Math.pow(10,2);
        if (val > 0) {
            return '<div style="color:green;bold:300"><img src="./lib/ext/examples/shared/icons/fam/positiveArrow.gif"/> '+ value + '</div>';
        } else if (val < 0) {
            return '<div style="color:red;bold:300""><img src="./lib/ext/examples/shared/icons/fam/negativeArrow.gif"/> '+ value + '</div>';
        }
        return val;
    }

    /**
     * Custom function used for column renderer
     * @param {Object} val
     */
    function pctChange(val) {
        var value = Math.round(val*Math.pow(10,2))/Math.pow(10,2);
        if (val > 0) {
            return '<div style="background-color:#BDECB6;color:green;bold:300">' + value + '%</div>';
        } else if (val < 0) {
            return '<div style="background-color:#EC6363;color:#530D0D;bold:300">' + value + '%</div>';
        }
        return val;
    }

    function imgManageIcon(value, metadata, record){
        return '<a href="#" ><img src="./lib/ext/examples/shared/icons/fam/chart.png" width="20" align="center"></a>';

    }

    var store = Ext.create('Ext.data.Store', {
        autoLoad: true,
        autoSync: true,
        model: 'Company',
        sorters: ['company', 'price', 'closePrice', 'change', 'pctChange', 'lastChange', 'sector','industry'],
        groupField: 'sector',
        proxy: {
            type: 'rest',
            url: 'http://localhost:8080/hello',
            reader: {
                type: 'json',
                root: 'data'
            }
        }
    });

    var groupingFeature = Ext.create('Ext.grid.feature.Grouping',{
        groupHeaderTpl: 'Sector: {name} ({rows.length} Position{[values.rows.length > 1 ? "s" : ""]})'
    });

    // Overview Grid
    var overViewGrid = Ext.create('Ext.grid.Panel', {
        store: store,
        stateId: 'stateGrid',
        invalidateScrollerOnRefresh: false,
        features: [groupingFeature],
        columns: [
            {
                header: '',
                width: 90,
                renderer: imgManageIcon
            },{
                text     : 'Sector',
                width    : 150,
                dataIndex: 'sector',
                hidden: true
            },{
                text     : 'Company',
                width     : 200,
                sortable : true,
                dataIndex: 'company'
            },{
                text     : 'Symbol',
                width     : 50,
                sortable : true,
                dataIndex: 'symbol'
            },{
                text     : 'Industry',
                width    :  150,
                dataIndex: 'industry'
            },{
                text     : 'Close',
                flex     : 50,
                sortable : true,
                dataIndex: 'openPrice',
                renderer : 'usMoney'
            },{
                text     : 'Quantity',
                width    : 55,
                sortable : true,
                dataIndex: 'quantity'
            },{
                text     : 'Price',
                width    : 55,
                sortable : true,
                renderer:  price,
                dataIndex: 'lastPrice'
            },{
                text     : 'Change',
                width    : 75,
                sortable : true,
                renderer : change,
                dataIndex: 'change'
            },{
                text     : '% Change',
                width    : 75,
                sortable : true,
                renderer : pctChange,
                dataIndex: 'changePercentage'
            },{
                text     : 'Last Updated',
                width    : 85,
                sortable : true,
                renderer : Ext.util.Format.dateRenderer('m/d/Y'),
                dataIndex: 'lastChange'
            },{
                menuDisabled: true,
                sortable: true,
                xtype: 'actioncolumn',
                width: 50,
                items: [{
                    icon   : 'lib/ext/examples/shared/icons/fam/delete.gif',  // Use a URL in the icon config
                    tooltip: 'Instruct Fund To Sell stock',
                    handler: function(grid, rowIndex, colIndex) {
                        var rec = store.getAt(rowIndex);
                        alert("Sell " + rec.get('company'));
                    }
                }, {
                    getClass: function(v, meta, rec) {          // Or return a class from a function
                        if (rec.get('change') < 0) {
                            this.items[1].tooltip = 'Hold stock (Do Nothing)';
                            return 'alert-col';
                        } else {
                            this.items[1].tooltip = 'Buy More stock';
                            return 'buy-col';
                        }
                    },
                    handler: function(grid, rowIndex, colIndex) {
                        var rec = store.getAt(rowIndex);
                        alert((rec.get('change') < 0 ? "Hold " : "Buy ") + rec.get('company'));
                    }
                }]
            }],
        fbar  : [ {
            text:'Clear Grouping',
            iconCls: 'icon-clear-group',
            handler : function(){
                groupingFeature.disable();
            }
        }],
        title: 'Overview',
        viewConfig: {
            stripeRows: true,
            enableTextSelection: true
        }
    });


    var performanceGrid = Ext.create('Ext.grid.Panel', {
        store: store,
        stateId: 'stateGrid',
        invalidateScrollerOnRefresh: false,
        columns: [
            {
                text     : 'Company',
                width     : 200,
                sortable : true,
                dataIndex: 'company'
            },{
                text     : 'Symbol',
                width     : 50,
                sortable : true,
                dataIndex: 'symbol'
            },{
                text     : 'Purchased Price',
                width    : 55,
                sortable : true,
                renderer:  price,
                dataIndex: 'purchasedPrice'
            },{
                text     : 'Last Price',
                width    : 55,
                sortable : true,
                renderer:  price,
                dataIndex: 'lastPrice'
            },{
                text     : 'Change',
                width    : 75,
                sortable : true,
                renderer : change,
                dataIndex: 'change'
            },{
                text     : '% Change',
                width    : 75,
                sortable : true,
                renderer : pctChange,
                dataIndex: 'changePercentage'
            },{
                text     : 'Quantity',
                width    : 55,
                sortable : true,
                dataIndex: 'quantity'
            },{
                text     : 'Cost Basis',
                width    :  150,
                dataIndex: 'costBasis',
                renderer: Ext.util.Format.usMoney
            },{
                text     : 'Market Value',
                width    :  150,
                dataIndex: 'marketValue',
                renderer: Ext.util.Format.usMoney
            },{
                text     : 'Gain',
                width    : 75,
                sortable : true,
                renderer : change,
                dataIndex: 'gain'
            },{
                text     : 'Gain %',
                width    : 75,
                sortable : true,
                renderer : pctChange,
                dataIndex: 'gainPercentage'
            },{
                menuDisabled: true,
                sortable: true,
                xtype: 'actioncolumn',
                width: 50
            }],
        fbar  : [ {
            text:'Clear Grouping',
            iconCls: 'icon-clear-group',
            handler : function(){
                groupingFeature.disable();
            }
        }],
        title: 'Performance',
        viewConfig: {
            stripeRows: true,
            enableTextSelection: true
        }
    });

    var fundamentals =  Ext.create('Ext.grid.Panel', {
        store: store,
        stateId: 'stateGrid',
        invalidateScrollerOnRefresh: false,
        columns: [
            {
                text     : 'Company',
                width     : 200,
                sortable : true,
                dataIndex: 'company'
            },{
                text     : 'Symbol',
                width     : 50,
                sortable : true,
                dataIndex: 'symbol'
            },{
                text     : 'Last Price',
                width    : 55,
                sortable : true,
                renderer:  price,
                dataIndex: 'lastPrice'
            },{
                text     : 'Market Cap',
                width    : 75,
                sortable : true,
                dataIndex: 'marketCap'
            },{
                text     : 'Avg vol',
                width    : 75,
                sortable : true,
                dataIndex: 'averageVolume'
            },{
                text     : '52wk high',
                width    : 55,
                sortable : true,
                dataIndex: 'weekHigh52',
                renderer: Ext.util.Format.usMoney
            },{
                text     : '52wk low',
                width    :  150,
                dataIndex: 'weekLow52',
                renderer: Ext.util.Format.usMoney
            },{
                text     : 'EPS',
                width    :  150,
                dataIndex: 'earningsPerShare',
                renderer: Ext.util.Format.usMoney
            },{
                text     : 'P/E',
                width    : 75,
                sortable : true,
                dataIndex: 'priceEarningsRatio'
            },{
                text     : 'Beta',
                width    : 75,
                sortable : true,
                dataIndex: 'beta'
            },{
                menuDisabled: true,
                sortable: true,
                xtype: 'actioncolumn',
                width: 50
            }],
        fbar  : [ {
            text:'Clear Grouping',
            iconCls: 'icon-clear-group',
            handler : function(){
                groupingFeature.disable();
            }
        }],
        title: 'Fundamentals',
        viewConfig: {
            stripeRows: true,
            enableTextSelection: true
        }
    });

    Ext.create('Ext.container.Viewport', {
        layout: 'border',
        items: [{
            region: 'center',
            xtype: 'tabpanel', // TabPanel itself has no title
            activeTab: 0,      // First tab active by default
            items: [ overViewGrid, fundamentals,  performanceGrid ]
        }]
    });

    var runner = new Ext.util.TaskRunner();
    runner.start({run: function() { store.load() }, interval: 2000 });
});
