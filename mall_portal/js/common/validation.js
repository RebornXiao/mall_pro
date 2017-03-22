
define( [ 'jquery',"validators" ], function($, validators ) {
	 var
	    container = $( "#container" );
    var

    namespace = "$ui.validation",

    Validation = function( container, settings ) {
console.info("====Validation===");
        var self = this;

        settings.validators = $.extend( {}, validators, settings.validators );

        this.$node = container;
        this.settings = settings;

        container
        .delegate( "input[type=reset]", "click", function() {
            self.clean();
        } );

        if ( settings.autoValidate ) {
            container
            .delegate( settings.selector, "focusout", function( e ) {
                self.validate( [ $( this ) ] );
            } );
        }
    };

    function mouseenter( e ) {
console.info("====mouseenter===");
        var
        self = $( this ),
        container = e.data.container,
        message = e.data.message,
        tooltipOffset = e.data.tooltipOffset,
        offset = self.offset(),
        containerOffset = container.offset(),
        tooltip;

        if ( self.hasClass( "md-validation-tooltiped" ) ) { return; }

        tooltip = $( "<div class='md-validation-message'><p>" + message + "</p></div>" )
            .css( {
                "position": "absolute",
                "top": offset.top - 30 - containerOffset.top + (tooltipOffset.top || 0),
                "left": offset.left - containerOffset.left + (tooltipOffset.left || 0)
            } )
            .appendTo( container );

        self.addClass( "md-validation-tooltiped" ).data( "tooltip", tooltip );
        self.off( "mouseleave", mouseleave ).on( "mouseleave", { target: self, tooltip: tooltip }, mouseleave );
        setTimeout( function() { tooltip.addClass( "md-error-show" ); } );
    }

    function mouseleave( e ) {
console.info("====mouseleave===");
        var tooltip = e.data.tooltip;

        tooltip.removeClass( "md-error-show" );
        setTimeout( function() { tooltip.remove(); }, 300 );
        e.data.target.removeClass( "md-validation-tooltiped" );
    }

    function clean( target, settings ) {
console.info("====clean===");
        target
        /** Remove all events and classes */
        .removeClass( settings.class4error )
        .off( "mouseenter", mouseenter )
        .off( "mouseleave", mouseleave )
        .removeClass( "md-validation-tooltiped" )
        .removeData( "tooltip" );
    }

    function change( e ) {
console.info("====change===");
        var
        instance = e.data.args.instance,
        settings = instance.settings,
        target = e.data.args.target,
        parameter = e.data.args.parameter,
        validator = e.data.args.validator;

        $.when( validator.call( settings.validators, target.val(), parameter, target, instance ) )
            .done( function() {
                var tooltip = target.data( "tooltip" );

                clean( target, settings );

                tooltip && tooltip.remove();
            } );
    }

    Validation.prototype = {
        validate: function( eles ) {

            var
            self = this,
            settings = this.settings,
            deferreds = [],
            eles = eles || this.$node.find( settings.selector );

            function getMessage( target ) {
console.info("====getMessage===");
                var
                messages = target.attr( "messages" ),
                matched = (messages || "").match( /(\w+\s*:\s*'[^']+')+/g ) || [];

                messages = {};

                while ( matched.length ) {
                    var expr = matched.pop().split( ":" );
                    messages[ expr[0].trim() ] = expr[1].replace( /^\s*'|'\s*/g, "" );
                }
             
                return messages;
            }

            function handle( target, validator, messages ) {
console.info("====handle===");
                var
                deferred,
                result,
                parameter,
                message,
                validatorType = validator;
               
                if ( "string" === typeof validator ) {
                    message = messages[ validator ];
                    validator = settings.validators[ validator ];
                } else {

                    var
                    /** Use the first validator, ignore others */
                    key = Object.keys( validator )[0],
                    parameter = validator[ key ],
                    validator = settings.validators[ key ];
                    message = messages[ key ];

                    if ( !validator && parameter instanceof Function ) {
                        validator = parameter;
                        parameter = void 0;
                    }
                }

                message = message || settings.message;

                result = validator.call( settings.validators, target.val(), parameter, target, self );
                

                if ( result === false ) {                	
                    deferred = $.Deferred();
                    deferred.reject();
                } else {
                    deferred = result;
                }

                target = settings.parseElement( target, settings );

                $.when( deferred )
                    .fail( function() {
                        target
                        .addClass( settings.class4error )                       
                        .off( "mouseenter", mouseenter );
                        target.parents(".inputbox").find("."+settings.showErrorClass).text(message);
                        target.parents(".inputbox").find("span").html(message);
                        console.info("1"+target.parents(".inputbox").find("."+settings.showErrorClass).text());
                        console.info("2"+target.parents(".inputbox").text());
                        console.info("3:"+target.text());
                        if ( settings.showMessage ) {

                            target
                            .on( "mouseenter", {
                                message: message,
                                container: self.$node,
                                tooltipOffset: settings.tooltipOffset || {}
                            }, mouseenter );
                        }
                    } )
                    .done( function() {
                        target
                        .removeClass( settings.class4error )
                        .off( "mouseenter", mouseenter )
                        .off( "mouseleave", mouseleave );
                        target.parents(".inputbox").find("span").text("");
                    } );

                deferreds.push( deferred );

                target.off( "change", change ).on( "change"
                        , { args: { target: target, validator: validator, parameter: parameter, instance: self } }
                        , change );

                return result;
            }

            for ( var i = eles.length; --i >= 0; ) {

                var
                ele = $( eles[i] ),
                messages = getMessage( ele ),
                validators = ele.attr( "validators" );

                try {
                    validators = eval( validators );
                } catch( ex ) {
                    validators = [];
                }

                for ( var m = 0, length = validators.length; m < length; ++m ) {

                    if ( !handle( ele, validators[ m ], messages ) && settings.breakOnError ) {
                        break;
                    }
                }
            }

            return $.when.apply( $, deferreds );
        },

        series: function(selector) {
console.info("====series===");
            var params = {},
            	nodes;
            if(selector){
            	nodes = this.$node.find(selector);
            }else{
            	nodes = this
                 .$node
                 .find( "input, radio, select, textarea" );
            }

            nodes.each( function(){

                var
                self = $( this ),
                name = self.attr( "name" );

                params[ name ] = self.val();
            });

            return params;
        },

        clean: function() {

            var settings = this.settings;

            this
            .$node
            .find( settings.selector )
            .each( function() {
                clean( settings.parseElement( $( this ).val( "" ).trigger( "focusout" ) ), settings );
            } );

            return this;
        }
    };

    $.fn.validation = function( options, override ) {

        var
        instance = this.data( namespace );

        if ( !instance || override === true ) {
            instance = new Validation( this, $.extend( true, {}, $.fn.validation.defaults, options ) );
            this.data( namespace, instance );
        }

        return instance;
    };


    $.fn.validation.defaults = {

        class4error     : "error-remind",
        selector        : "input[validators]:visible:not(button)",
        showErrorClass  : "error-remind",
        message         : "Invalid input",
        breakOnError    : true,
        showMessage     : true,
        autoValidate    : false,

        /** TODO: bootstrap form-control */
        parseElement    : function( target ) {
console.info("====parseElement===");
            var parent = target.parent();

            if ( target.is( "select, input[type=checkbox], input[type=radio]" ) && parent.is( ".md-select, .md-switch, .md-radio" ) ) {

                if ( target.is( ":radio" ) && parent.parent().is( ".ui.radioes" ) ) {
                    return parent.parent();
                }

                return parent;
            } else if ( target.is( "input[type=checkbox]" ) && (parent = target.parents( ".ui.checkboxes:first" ), parent.length) ) {
                return parent;
            }

            return target;
        },

        validators      : {}
    };
} );
