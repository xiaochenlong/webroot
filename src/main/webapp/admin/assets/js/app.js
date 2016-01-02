/**
 * Created by Administrator on 2016/1/2.
 */
(function($){
    var App = {};
    App.view_siberbar = function(item,layze){
        var html=[];
        html.push('<li class="">');
        var menutext = layze>1?item.title:'<span class="menu-text"> '+item.title+' </span>';
        var flag_sub = !!item.submenu;
        var dropdown_css = flag_sub?'dropdown-toggle':'';
        var href = flag_sub?'#':'page/'+item.link;
        var downb =flag_sub?'<b class="arrow fa fa-angle-down"></b>':'';
        html.push('<a data-url="'+href+'" href="#'+href+'" class="'+dropdown_css+'">');
        html.push('<i class="menu-icon '+item.icon+'"></i>');
        html.push(menutext);
        html.push(downb);
        html.push('</a>');
        html.push('<b class="arrow"></b>');
        if(flag_sub){
            html.push('<ul class="submenu">');
            var submenus = item.submenu;
            $.each(submenus,function(i,subm){
                html.push(App.view_siberbar(subm,layze+1));
            });
            html.push('</ul>');
        }
        html.push('</li>');
        return html.join('');
    };

    window.App = App;
})($);