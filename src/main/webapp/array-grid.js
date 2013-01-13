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
       {name: 'fund'},
       {name: 'price',      type: 'float', convert: null,     defaultValue: undefined},
       {name: 'closePrice', type: 'float', convert: null,     defaultValue: undefined},
       {name: 'change',     type: 'float', convert: null,     defaultValue: undefined},
       {name: 'pctChange',  type: 'float', convert: null,     defaultValue: undefined},
       {name: 'lastChange', type: 'date',  dateFormat: 'n/j h:ia', defaultValue: undefined}
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

    var store = Ext.create('Ext.data.Store', {
        autoLoad: true,
        autoSync: true,
        model: 'Company',
        sorters: ['company', 'price', 'closePrice', 'change', 'pctChange', 'lastChange'],
        groupField: 'fund',
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
            groupHeaderTpl: 'Portfolio: {name} ({rows.length} Position{[values.rows.length > 1 ? "s" : ""]})'
        });

    // create the Grid
    var grid = Ext.create('Ext.grid.Panel', {
        store: store,
        stateId: 'stateGrid',
        invalidateScrollerOnRefresh: false,
        features: [groupingFeature],
        columns: [
            {
                 text     : 'Hedge Fund',
                 width    : 150,
                 dataIndex: 'fund',
                 hidden: true
            },{
                text     : 'Company',
                width     : 200,
                sortable : false,
                dataIndex: 'company'
            },{
                text     : 'Close',
                flex     : 50,
                sortable : false,
                dataIndex: 'closePrice',
                renderer : 'usMoney'
            },
            {
                text     : 'Price',
                width    : 55,
                sortable : true,
                renderer:  price,
                dataIndex: 'price'
            },
            {
                text     : 'Change',
                width    : 75,
                sortable : true,
                renderer : change,
                dataIndex: 'change'
            },
            {
                text     : '% Change',
                width    : 75,
                sortable : true,
                renderer : pctChange,
                dataIndex: 'pctChange'
            },
            {
                text     : 'Last Updated',
                width    : 85,
                sortable : true,
                renderer : Ext.util.Format.dateRenderer('m/d/Y'),
                dataIndex: 'lastChange'
            },{
                menuDisabled: true,
                sortable: false,
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
        height: 350,
        width: 800,
        title: 'Companies Grid',
        viewConfig: {
            stripeRows: true,
            enableTextSelection: true
        }
    });

    var fitLayout = new Ext.Panel({
        layout:'fit',
        renderTo: 'grid-example',
        items: grid
    });

    var runner = new Ext.util.TaskRunner();
    runner.start({run: function() { store.load() }, interval: 2000 });
});
