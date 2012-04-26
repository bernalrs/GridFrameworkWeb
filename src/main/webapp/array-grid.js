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
    function change(val) {
        if (val > 0) {
            return '<span style="color:green;">' + val + '</span>';
        } else if (val < 0) {
            return '<span style="color:red;">' + val + '</span>';
        }
        return val;
    }

    /**
     * Custom function used for column renderer
     * @param {Object} val
     */
    function pctChange(val) {
        if (val > 0) {
            return '<span style="color:green;">' + val + '%</span>';
        } else if (val < 0) {
            return '<span style="color:red;">' + val + '%</span>';
        }
        return val;
    }

    var store = Ext.create('Ext.data.Store', {
        autoLoad: true,
        autoSync: true,
        model: 'Company',
        sorters: ['company', 'price', 'change', 'pctChange', 'lastChange'],
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
            groupHeaderTpl: 'HedgeFund: {name} ({rows.length} Position{[values.rows.length > 1 ? "s" : ""]})'
        });

    // create the Grid
    var grid = Ext.create('Ext.grid.Panel', {
        store: store,
        stateId: 'stateGrid',
        features: [groupingFeature],
        columns: [
            {
                 text     : 'HedgeFund',
                 width    : 120,
                 dataIndex: 'fund'
            },{
                text     : 'Company',
                flex     : 1,
                sortable : false,
                dataIndex: 'company'
            },
            {
                text     : 'Price',
                width    : 75,
                sortable : true,
                renderer : 'usMoney',
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
                    icon   : 'lib/examples/shared/icons/fam/delete.gif',  // Use a URL in the icon config
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
            }
        ],
        height: 350,
        width: 600,
        title: 'Companies Grid',
        renderTo: 'grid-example',
        viewConfig: {
            stripeRows: true,
            enableTextSelection: true
        }
    });
});
